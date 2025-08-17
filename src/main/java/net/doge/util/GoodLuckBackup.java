package net.doge.util;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * 好运连连
 */
public class GoodLuckBackup {
    public static void main(String[] args) {
        Integer[] g = {1, 2, 3, 4};
//        Integer[] g = {1, 2, 3};
        List<Integer> list = Arrays.asList(g);

        for (int j = 1, t = 10; j <= t; j++) {
            shuffle(list);
            System.out.printf("第 %s 个：", j);
            for (int i = 0, s = list.size() - 1; i < s; i++) System.out.print(list.get(i) + " ");
            System.out.println();
        }
    }

    // 使用Fisher-Yates算法打乱列表
    public static <T> void shuffle(List<T> list) {
        MersenneTwister rnd = new MersenneTwister();
        for (int i = list.size() - 1; i > 0; i--) {
            // 生成[0, i]范围内的随机索引
            int j = rnd.nextInt(i + 1);
            // 交换当前位置 i 和随机位置j的元素
            T temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
    }

    public static class MersenneTwister extends BitsStreamGenerator implements Serializable {
        private static final long serialVersionUID = 8661194735290153518L;
        private static final int N = 624;
        private static final int M = 397;
        private static final int[] MAG01 = new int[]{0, -1727483681};
        private int[] mt = new int[624];
        private int mti;

        public MersenneTwister() {
            this.setSeed(System.currentTimeMillis() + (long)System.identityHashCode(this));
        }

        public MersenneTwister(int seed) {
            this.setSeed(seed);
        }

        public MersenneTwister(int[] seed) {
            this.setSeed(seed);
        }

        public MersenneTwister(long seed) {
            this.setSeed(seed);
        }

        public void setSeed(int seed) {
            long longMT = (long)seed;
            this.mt[0] = (int)longMT;

            for(this.mti = 1; this.mti < 624; ++this.mti) {
                longMT = 1812433253L * (longMT ^ longMT >> 30) + (long)this.mti & 4294967295L;
                this.mt[this.mti] = (int)longMT;
            }

            this.clear();
        }

        public void setSeed(int[] seed) {
            if (seed == null) {
                this.setSeed(System.currentTimeMillis() + (long)System.identityHashCode(this));
            } else {
                this.setSeed(19650218);
                int i = 1;
                int j = 0;

                for(int k = Math.max(624, seed.length); k != 0; --k) {
                    long l0 = (long)this.mt[i] & 2147483647L | (this.mt[i] < 0 ? 2147483648L : 0L);
                    long l1 = (long)this.mt[i - 1] & 2147483647L | (this.mt[i - 1] < 0 ? 2147483648L : 0L);
                    long l = (l0 ^ (l1 ^ l1 >> 30) * 1664525L) + (long)seed[j] + (long)j;
                    this.mt[i] = (int)(l & 4294967295L);
                    ++i;
                    ++j;
                    if (i >= 624) {
                        this.mt[0] = this.mt[623];
                        i = 1;
                    }

                    if (j >= seed.length) {
                        j = 0;
                    }
                }

                for(int k = 623; k != 0; --k) {
                    long l0 = (long)this.mt[i] & 2147483647L | (this.mt[i] < 0 ? 2147483648L : 0L);
                    long l1 = (long)this.mt[i - 1] & 2147483647L | (this.mt[i - 1] < 0 ? 2147483648L : 0L);
                    long l = (l0 ^ (l1 ^ l1 >> 30) * 1566083941L) - (long)i;
                    this.mt[i] = (int)(l & 4294967295L);
                    ++i;
                    if (i >= 624) {
                        this.mt[0] = this.mt[623];
                        i = 1;
                    }
                }

                this.mt[0] = Integer.MIN_VALUE;
                this.clear();
            }
        }

        public void setSeed(long seed) {
            this.setSeed(new int[]{(int)(seed >>> 32), (int)(seed & 4294967295L)});
        }

        protected int next(int bits) {
            if (this.mti >= 624) {
                int mtNext = this.mt[0];

                for(int k = 0; k < 227; ++k) {
                    int mtCurr = mtNext;
                    mtNext = this.mt[k + 1];
                    int y = mtCurr & Integer.MIN_VALUE | mtNext & Integer.MAX_VALUE;
                    this.mt[k] = this.mt[k + 397] ^ y >>> 1 ^ MAG01[y & 1];
                }

                for(int k = 227; k < 623; ++k) {
                    int mtCurr = mtNext;
                    mtNext = this.mt[k + 1];
                    int y = mtCurr & Integer.MIN_VALUE | mtNext & Integer.MAX_VALUE;
                    this.mt[k] = this.mt[k + -227] ^ y >>> 1 ^ MAG01[y & 1];
                }

                int y = mtNext & Integer.MIN_VALUE | this.mt[0] & Integer.MAX_VALUE;
                this.mt[623] = this.mt[396] ^ y >>> 1 ^ MAG01[y & 1];
                this.mti = 0;
            }

            int y = this.mt[this.mti++];
            y ^= y >>> 11;
            y ^= y << 7 & -1658038656;
            y ^= y << 15 & -272236544;
            y ^= y >>> 18;
            return y >>> 32 - bits;
        }
    }

    public abstract static class BitsStreamGenerator implements RandomGenerator, Serializable {
        private static final long serialVersionUID = 20130104L;
        private double nextGaussian = Double.NaN;

        public abstract void setSeed(int var1);

        public abstract void setSeed(int[] var1);

        public abstract void setSeed(long var1);

        protected abstract int next(int var1);

        public boolean nextBoolean() {
            return this.next(1) != 0;
        }

        public double nextDouble() {
            long high = (long)this.next(26) << 26;
            int low = this.next(26);
            return (double)(high | (long)low) * (double)2.220446E-16F;
        }

        public float nextFloat() {
            return (float)this.next(23) * 1.1920929E-7F;
        }

        public double nextGaussian() {
            double random;
            if (Double.isNaN(this.nextGaussian)) {
                double x = this.nextDouble();
                double y = this.nextDouble();
                double alpha = (Math.PI * 2D) * x;
                double r = Math.sqrt((double)-2.0F * Math.log(y));
                random = r * Math.cos(alpha);
                this.nextGaussian = r * Math.sin(alpha);
            } else {
                random = this.nextGaussian;
                this.nextGaussian = Double.NaN;
            }

            return random;
        }

        public int nextInt() {
            return this.next(32);
        }

        public int nextInt(int n) throws IllegalArgumentException {
            if (n <= 0) {
                return -1;
            } else if ((n & -n) == n) {
                return (int)((long)n * (long)this.next(31) >> 31);
            } else {
                int bits;
                int val;
                do {
                    bits = this.next(31);
                    val = bits % n;
                } while(bits - val + (n - 1) < 0);

                return val;
            }
        }

        public long nextLong() {
            long high = (long)this.next(32) << 32;
            long low = (long)this.next(32) & 4294967295L;
            return high | low;
        }

        public long nextLong(long n) throws IllegalArgumentException {
            if (n <= 0L) {
                return -1;
            } else {
                long val;
                long var7;
                do {
                    long bits = (long)this.next(31) << 32;
                    var7 = bits | (long)this.next(32) & 4294967295L;
                    val = var7 % n;
                } while(var7 - val + (n - 1L) < 0L);

                return val;
            }
        }

        public void clear() {
            this.nextGaussian = Double.NaN;
        }

        public void nextBytes(byte[] bytes) {
            this.nextBytesFill(bytes, 0, bytes.length);
        }

        public void nextBytes(byte[] bytes, int start, int len) {
            if (start >= 0 && start < bytes.length) {
                if (len >= 0 && len <= bytes.length - start) {
                    this.nextBytesFill(bytes, start, len);
                } else {
                    System.out.println("异常");
                }
            } else {
                System.out.println("异常");
            }
        }

        private void nextBytesFill(byte[] bytes, int start, int len) {
            int index = start;

            int random;
            for(int indexLoopLimit = start + (len & 2147483644); index < indexLoopLimit; bytes[index++] = (byte)(random >>> 24)) {
                random = this.next(32);
                bytes[index++] = (byte)random;
                bytes[index++] = (byte)(random >>> 8);
                bytes[index++] = (byte)(random >>> 16);
            }

            random = start + len;
            if (index < random) {
                random = this.next(32);

                while(true) {
                    bytes[index++] = (byte)random;
                    if (index >= random) {
                        break;
                    }

                    random >>>= 8;
                }
            }

        }
    }

    public interface RandomGenerator {
        void setSeed(int var1);

        void setSeed(int[] var1);

        void setSeed(long var1);

        void nextBytes(byte[] var1);

        int nextInt();

        int nextInt(int var1);

        long nextLong();

        boolean nextBoolean();

        float nextFloat();

        double nextDouble();

        double nextGaussian();
    }
}
