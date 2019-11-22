package com.study.blog.util.uid;

public class IdTool {
    public IdTool() {
    }

    public static String nextSmallId() {
        SmallIdGenerator smallGen  = SmallIdGenerator.getGenerator();
        return smallGen.nextId();
    }
}
