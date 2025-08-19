package mianjing;


/**
 * 怎么使用两个线程循环打印出1~100？
 * 通过一个共享的布尔标志位控制哪个线程可以执行，配合 wait() 和 notify() 实现线程间的协调。
 *
 * 第一步：问题建模
 * 需求：两个线程交替打印 1-100
 * 关键词：交替 → 需要协调机制
 * 第二步：设计思路
 *
 * 状态控制：用一个变量控制轮次
 * 互斥保护：确保状态检查和修改的原子性
 * 阻塞唤醒：不是自己回合时等待，轮到时被唤醒
 *
 * 第三步：实现选择
 * java// 方案对比：
 * // 1. wait/notify：灵活但复杂
 * // 2. Semaphore：简洁但功能单一
 * // 3. Lock/Condition：功能强大但重量级
 * @author Tori
 */
public class TwoThreadPrint {

    // 方法1：使用共享变量和锁
    static class Method1 {
        // 要打印的数字
        private static int num = 1;
        // 同步锁对象
        private static final Object lock = new Object();
        // 控制标志：true=线程A执行，false=线程B执行
        private static boolean flag = true; // true表示线程A打印，false表示线程B打印

        public static void run() {
            Thread threadA = new Thread(() -> {
                while (num <= 100) {
                    // 确保同一时刻只有一个线程访问共享变量
                    synchronized (lock) {
                        // 关键步骤1：检查是否轮到自己
                        // 防止虚假唤醒：wait() 可能会被意外唤醒，while 确保被唤醒后重新检查条件
                        // 双重检查：既检查轮次（flag），也检查边界条件（num <= 100） 避免越界：当 num 超过 100 时，等待中的线程应该退出，不应该继续打印
                        while (!flag && num <= 100) {
                            try {
                                // 不是自己的回合，等待
                                // 释放锁并等待，让其他线程有机会执行
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                                return;
                            }
                        }
                        // 关键步骤2：执行自己的任务
                        if (num <= 100) {
                            System.out.println("线程A: " + num++);
                            // 切换到线程B
                            flag = false;
                            // 唤醒等待的线程B 唤醒一个等待的线程
                            lock.notify();
                        }
                    }
                }
            }, "线程A");

            Thread threadB = new Thread(() -> {
                while (num <= 100) {
                    synchronized (lock) {
                        // 关键步骤1：检查是否轮到自己
                        while (flag && num <= 100) {
                            try {
                                //不是自己的回合，等待
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                                return;
                            }
                        }
                        // 关键步骤2：执行自己的任务
                        if (num <= 100) {
                            System.out.println("线程B: " + num++);
                            //切换到线程A
                            flag = true;
                            // 唤醒等待的线程A
                            lock.notify();
                        }
                    }
                }
            }, "线程B");

            threadA.start();
            threadB.start();

            try {
                threadA.join();
                threadB.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 方法2：使用内部类的方式
    static class PrintTask implements Runnable {
        private static int num = 1;
        // 1. 锁的本质
        // 在 Java 中，每个对象都有一个内置的监视器锁（monitor）。synchronized 关键字实际上是获取这个对象的监视器锁。

        private static final Object lock = new Object();
        private static boolean flag = true;

        private final boolean isThreadA;

        public PrintTask(boolean isThreadA) {
            this.isThreadA = isThreadA;
        }

        @Override
        public void run() {
            while (num <= 100) {
                synchronized (lock) {
                    // 如果当前不是该线程的回合，就等待
                    while ((isThreadA && !flag) || (!isThreadA && flag)) {
                        if (num > 100) {
                          break;
                        }
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            return;
                        }
                    }

                    if (num <= 100) {
                        System.out.println(Thread.currentThread().getName() + ": " + num++);
                        flag = !flag; // 切换标志
                        lock.notify();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== 方法1：直接在main中实现 ===");
        Method1.run();

//        System.out.println("\n=== 方法2：使用Runnable实现 ===");
        // 重置静态变量
//        PrintTask.num = 1;
//        PrintTask.flag = true;

//        Thread threadA = new Thread(new PrintTask(true), "线程A");
//        Thread threadB = new Thread(new PrintTask(false), "线程B");
//        threadA.start();
//        threadB.start();
//
//        try {
//            threadA.join();
//            threadB.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println("打印完成！");
    }
}


// 记忆要点：
// 在多线程编程中，wait() 前面永远使用 while，这是一个铁律！
// 使用 while 的三个关键原因：
//防止虚假唤醒：
//虚假唤醒是真实存在的现象
//while 确保被唤醒后重新检查条件
//只有条件真正满足时才继续执行
//保证条件的持续性：
//条件可能在等待期间被其他线程改变
//while 确保条件在执行时仍然有效
//边界条件保护：
//num <= 100 确保不会越界
//当游戏结束时，等待中的线程能正确退出