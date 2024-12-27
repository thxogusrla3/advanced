package hello.advanced.trace;

import java.util.UUID;

public class TraceId {
    private String id; //요청 단위의 ID
    private int level; // 예제 controller - service - repository

    public TraceId() {
        this.id = createId();
        this.level = 0;
    }

    public TraceId(String id, int level) {
        this.id = id;
        this.level = level;
    }

    private String createId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public TraceId createNextId() {
        return new TraceId(id, level + 1);
    }

    public TraceId createPreviousId() {
        return new TraceId(id, level - 1);
    }

    public boolean isFirstLeven() {
        return level == 0;
    }

    public int getLevel() {
        return this.level;
    }

    public String getId() {
        return id;
    }
}
