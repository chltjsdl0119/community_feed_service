package seungwon.community_feed_service.common.domain;

public class PositiveIntegerCounter {

    private int count;

    public PositiveIntegerCounter() {
        this.count = 0;
    }

    public PositiveIntegerCounter(int likeCount) {
        this.count = likeCount;
    }

    public void increase() {
        this.count++;
    }

    public void decrease() {
        if (count <= 0) {
            return;
        }

        this.count--;
    }

    public int getCount() {
        return count;
    }
}
