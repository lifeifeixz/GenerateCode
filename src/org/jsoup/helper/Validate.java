package org.jsoup.helper;

/**
 * Simple validation methods. Designed for jsoup internal use
 */
public final class Validate {

    private Validate() {
    }

    /**
     * Validates that the object is not null
     *
     * @param obj object to test
     */
    public static void notNull(Object obj) {
        if (obj == null)
            throw new IllegalArgumentException("Object must not be null");
    }

    /**
     * Validates that the object is not null
     *
     * @param obj object to test
     * @param msg message to output if validation fails
     */
    public static void notNull(Object obj, String msg) {
        if (obj == null)
            throw new IllegalArgumentException(msg);
    }

    /**
     * Validates that the value is true
     *
     * @param val object to test
     */
    public static void isTrue(boolean val) {
        if (!val) {
            throw new IllegalArgumentException("Must be true");
        }
    }

    /**
     * Validates that the value is true
     *
     * @param val object to test
     * @param msg message to output if validation fails
     */
    public static void isTrue(boolean val, String msg) {
        if (!val) {
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * 验证该值是否为false
     *
     * @param val object to test
     */
    public static void isFalse(boolean val) {
        if (val) {
            throw new IllegalArgumentException("一定是错误的");
        }
    }

    /**
     * 验证该值是否为false。
     *
     * @param val 验证的对象
     * @param msg 如果验证失败，则向输出发送消息
     */
    public static void isFalse(boolean val, String msg) {
        if (val) {
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * 验证数组中不包含null元素
     *
     * @param objects 要测试的数组
     */
    public static void noNullElements(Object[] objects) {
        noNullElements(objects, "数组不能包含任何空对象");
    }

    /**
     * 验证数组中不包含null元素
     *
     * @param objects 要测试的数组
     * @param msg     如果验证失败，则向输出发送消息
     */
    public static void noNullElements(Object[] objects, String msg) {
        for (Object obj : objects) {
            if (obj == null) {
                throw new IllegalArgumentException(msg);
            }
        }
    }

    /**
     * 验证字符串是否为空
     *
     * @param string 要测试的字符串
     */
    public static void notEmpty(String string) {
        if (string == null || string.length() == 0) {
            throw new IllegalArgumentException("字符串不能为空");
        }
    }

    /**
     * 验证字符串是否为空
     *
     * @param string 要测试的字符串
     * @param msg    如果验证失败，则向输出发送消息
     */
    public static void notEmpty(String string, String msg) {
        if (string == null || string.length() == 0) {
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * 导致失败.
     *
     * @param msg 消息输出.
     */
    public static void fail(String msg) {
        throw new IllegalArgumentException(msg);
    }
}
