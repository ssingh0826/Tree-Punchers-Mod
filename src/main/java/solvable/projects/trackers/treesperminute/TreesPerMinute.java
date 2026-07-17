package solvable.projects.trackers.treesperminute;

import java.util.ArrayDeque;
import java.util.Deque;

import solvable.projects.TreePuncherMod;

public class TreesPerMinute {

    private static final String PREFIX = "                                 TREE GIFT";
    private static final long WINDOW_MS = 60_000L;
    private final Deque<Long> expirationTimes = new ArrayDeque<>();
    private boolean active = false;

    public synchronized void handleTreeGiftMessage(String message)
    {
        active = true;
        if (!message.startsWith(PREFIX)) {
            return;
        }
        expirationTimes.addLast(System.currentTimeMillis() + WINDOW_MS);
    }

    public void tick() {
        if (!active) { return; }
        // render
    }

    public synchronized int getTreeGiftsPerMinute() { return expirationTimes.size(); }

    public synchronized void cleanup() {
        long now = System.currentTimeMillis();

        while (!expirationTimes.isEmpty() && expirationTimes.peekFirst() <= now) {
            expirationTimes.removeFirst();
        }

        if ((expirationTimes.peekLast() != null) && (expirationTimes.peekLast() <= (now + (TreePuncherMod.CONFIG.tpmTimeoutSeconds() * 1000L)))) { shutdown(); }
    }

    public void shutdown() {
        active = false;
        expirationTimes.clear();
    }

    public boolean isActive() { return active; }
}
