public class TokenBucketRateLimiter {
    
    long capacity;                      // 桶的容量
    long rate;                          // 令牌发放速率, permits-per-second
    long currentTokenNum;               // 当前桶中的令牌数量
    long lastAddTokenTime;              // 上次补充令牌的时间

    public TokenBucketRateLimiter(long capacity, long rate) {
        this.capacity = capacity;
        this.rate = rate;
        currentTokenNum = capacity;
        lastAddTokenTime = System.currentTimeMillis();
    }

    public boolean acquire() {
        return acquire(1);
    }

    public boolean acquire(int permits) {
        if (permits > currentTokenNum) {
            long accessTime = System.currentTimeMillis();
            long durationMs = accessTime - lastAddTokenTime;
            long newTokenNum = (long) (durationMs * rate * 1.0 / 1000);
            if (newTokenNum > 0) {
                currentTokenNum = Math.min(currentTokenNum + newTokenNum, capacity);
                this.lastAddTokenTime = accessTime;
            }
            if (permits > currentTokenNum) return false;
        }
        this.currentTokenNum -= permits;
        return true;
    }
}
