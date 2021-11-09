package Lzh0234.ex4;


import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*
 * JavaExp Lzh0234.ex4
 * @Author:Demon
 * @Date:2021/11/5 17:18
 * @Description:
 */
public class ThreeStageSquare
{
    //0号位作锁变量
    private static final boolean[][][] cache = new boolean[3][3][10];
    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);

    public static void execute(int[][] square, int i_, int j_)
    {
        boolean flag;
        //先调用thrice
        lock(square);
        if ((i_ + j_) % 2 == 0)
        {
            while (true)
            {
                //正对角线
                if (i_ - j_ == 0)
                {
                    flag = thricePoint(square, i_, j_, false);
                    if (!flag)
                    {
                        squareReset(square, i_, j_);
                    } else
                    {
                        flag = thricePoint(square, 0, 2, true);
                        if (!flag)
                        {
                            squareReset(square, i_, j_);
                        } else
                        {
                            flag = twicePoint(square, 1, 1);
                            if (!flag)
                            {
                                squareReset(square, i_, j_);
                            } else
                            {
                                if (checkSquare(square)) break;
                                else
                                {
                                    squareReset(square, i_, j_);
                                }
                            }
                        }
                    }
                }
                //反对角线
                else
                {
                    flag = thricePoint(square, i_, j_, true);
                    if (!flag)
                    {
                        squareReset(square, i_, j_);
                    } else
                    {
                        flag = thricePoint(square, 0, 0, false);
                        if (!flag)
                        {
                            squareReset(square, i_, j_);
                        } else
                        {
                            flag = twicePoint(square, 1, 1);
                            if (!flag)
                            {
                                squareReset(square, i_, j_);
                            } else
                            {
                                if (checkSquare(square)) break;
                                else
                                {
                                    squareReset(square, i_, j_);
                                }
                            }
                        }
                    }
                }
            }
        } else
        {
            if (i_ == 1 && j_ == 1)
            {
                if (square[i_][j_] != 5)
                {
                    System.out.println("生成失败");
                } else
                {
                    while (true)
                    {
                        flag = twicePoint(square, i_, j_);
                        if (!flag)
                        {
                            squareReset(square, i_, j_);
                            continue;
                        } else
                        {
                            flag = twicePoint(square, 0, 1);
                        }
                        if (!flag)
                        {
                            squareReset(square, i_, j_);
                        } else
                        {

                            flag = thricePoint(square, 0, 0, false);
                            if (!flag)
                            {
                                squareReset(square, i_, j_);
                            } else
                            {
                                flag = thricePoint(square, 0, 2, true);
                                if (!flag)
                                {
                                    squareReset(square, i_, j_);
                                } else
                                {
                                    if (checkSquare(square)) break;
                                    else
                                    {
                                        squareReset(square, i_, j_);
                                    }
                                }
                            }

                        }
                    }

                }
            } else
            {
                while (true)
                {
                    flag = twicePoint(square, i_, j_);
                    if (!flag)
                    {
                        squareReset(square, i_, j_);
                        continue;
                    } else
                    {
                        flag = twicePoint(square, 1, 1);
                    }
                    if (!flag)
                    {
                        squareReset(square, i_, j_);
                    } else
                    {
                        flag = thricePoint(square, 0, 0, false);
                        if (!flag)
                        {
                            squareReset(square, i_, j_);
                        } else
                        {
                            flag = thricePoint(square, 0, 2, true);
                            if (!flag)
                            {
                                squareReset(square, i_, j_);
                            } else
                            {
                                if (checkSquare(square)) break;
                                else
                                {
                                    squareReset(square, i_, j_);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static boolean checkSquare(int[][] square)
    {
        if (addRow(square, 0, 0)) return false;
        if (addRow(square, 1, 0)) return false;
        if (addRow(square, 2, 0)) return false;
        if (addCol(square, 0, 0)) return false;
        if (addCol(square, 0, 1)) return false;
        if (addCol(square, 0, 2)) return false;
        if (addBackDiagonal(square, 0, 2)) return false;
        return !addDiagonal(square, 0, 0);
    }

    public static void flashPointCache(int i, int j)
    {
        for (int z = 1; z < 10; z++) cache[i][j][z] = false;
    }

    public static boolean checkPointCacheFull(int i, int j)
    {
        for (int z = 1; z < 10; z++) if (!cache[i][j][z]) return false;
        return true;
    }

    public static int getRandomNum(int i, int j)
    {
        int loc;
        if (!checkPointCacheFull(i, j))
        {
            while (cache[i][j][loc = random.nextInt(9) + 1]) ;
            cache[i][j][loc] = true;
            return loc;
        } else return 0;
    }

    public static boolean twicePoint(int[][] square, int i_, int j_)
    {
        int temp, i, j;
        //初始点未有值
        while (true)
        {
            if (square[i_][j_] == 0)
            {
                //行另外两点是否被锁
                if (cache[i_][(j_ + 1) % 3][0] && cache[i_][(j_ + 2) % 3][0])
                {
                    //两锁时检查列是否被锁两点
                    if (cache[(i_ + 1) % 3][j_][0] && cache[(i_ + 2) % 3][j_][0])
                    {
                        if ((15 - square[i_][(j_ + 1) % 3] - square[i_][(j_ + 2) % 3]) == (15 - square[(i_ + 1) % 3][j_] - square[(i_ + 2) % 3][j_]))
                        {
                            cache[i_][j_][0] = true;
                            square[i_][j_] = 15 - square[i_][(j_ + 1) % 3] - square[i_][(j_ + 2) % 3];
                        } else return false;
                    } else
                    {
                        cache[i_][j_][0] = true;
                        square[i_][j_] = 15 - square[i_][(j_ + 1) % 3] - square[i_][(j_ + 2) % 3];
                    }
                } else
                {
                    //行两点都没锁，直接生成
                    if (!cache[i_][(j_ + 1) % 3][0] & !cache[i_][(j_ + 2) % 3][0]) square[i_][j_] =
                            getRandomNum(i_, j_);
                        //行锁了一点，根据锁的点确定生成的可行范围
                    else
                    {

                        if (cache[i_][(j_ + 1) % 3][0]) temp = square[i_][(j_ + 1) % 3];
                        else temp = square[i_][(j_ + 2) % 3];
                        cache[i_][j_][0] = true;
                        do
                        {
                            if (checkPointCacheFull(i_, j_)) return false;
                            square[i_][j_] = getRandomNum(i_, j_);
                        } while (15 - temp - square[i_][j_] > 9);
                    }
                }
            }
            //初始点有值
            else
            {
                boolean colModel = false;
                boolean tempLock = false;
                while (true)
                {
                    //列模式
                    if (colModel)
                    {
                        //整列都被封锁，此时行应是满的
                        if (cache[i_][j_][0] && cache[(i_ + 1) % 3][j_][0] && cache[(i_ + 2) % 3][j_][0])
                        {
                            return !addRow(square, i_, j_) & !addCol(square, i_, j_);
                        }

                    }
                    //行模式
                    else
                    {
                        //整行都被封锁
                        if (cache[i_][j_][0] && cache[i_][(j_ + 1) % 3][0] && cache[i_][(j_ + 2) % 3][0])
                        {
                            //addRow检测一行为15时返回false
                            if (!addRow(square, i_, j_))
                            {
                                colModel = true;
                                continue;
                            } else return false;
                        }
                    }
                    //行或列未被完全封锁时到此处
                    //确定是两个点都没锁还是只锁了一个点
                    //当前为列模式
                    if (colModel)
                    {
                        //给定点周围两个都没被封锁
                        if (!cache[(i_ + 1) % 3][j_][0] & !cache[(i_ + 2) % 3][j_][0])
                        {
                            i = (i_ + 1) % 3;
                            j = j_;
                            cache[i][j][0] = true;
                            tempLock = true;
                            do
                            {
                                if (checkPointCacheFull(i, j)) return false;
                                square[i][j] = getRandomNum(i, j);
                            } while (15 - square[i_][j_] - square[i][j] > 9);
                        }
                        //封锁了其中一个点
                        else
                        {
                            //此时给定点和封锁点一共两个点被封锁
                            if (cache[(i_ + 1) % 3][j_][0])
                            {
                                i = (i_ + 2) % 3;
                                j = j_;
                                temp = square[(i_ + 1) % 3][j_];
                            } else
                            {
                                i = (i_ + 1) % 3;
                                j = j_;
                                temp = square[(i_ + 2) % 3][j_];
                            }
                            //直接求解该点的值
                            temp = 15 - temp - square[i_][j_];
                            if (temp <= 9 & temp > 0)
                            {
                                cache[i][j][0] = true;
                                square[i][j] = temp;
                                return true;
                            } else
                            {
                                if (tempLock)
                                {
                                    if (cache[(i_ + 1) % 3][j_][0])
                                    {
                                        cache[(i_ + 1) % 3][j_][0] = false;
                                        tempLock = false;
                                        square[(i_ + 1) % 3][j_] = 0;
                                    } else
                                    {
                                        cache[(i_ + 2) % 3][j_][0] = false;
                                        tempLock = false;
                                        square[(i_ + 2) % 3][j_] = 0;
                                    }
                                    continue;
                                } else return false;
                            }
                        }

                    }
                    //行模式
                    else
                    {
                        //给定点周围两个都没被封锁
                        if (!cache[i_][(j_ + 1) % 3][0] & !cache[i_][(j_ + 2) % 3][0])
                        {
                            i = i_;
                            j = (j_ + 1) % 3;
                            cache[i][j][0] = true;
                            tempLock = true;
                            do
                            {
                                if (checkPointCacheFull(i, j)) return false;
                                square[i][j] = getRandomNum(i, j);
                            } while (15 - square[i_][j_] - square[i][j] > 9);
                        }
                        //封锁了其中一个点
                        else
                        {
                            //此时给定点和封锁点一共两个点被封锁
                            if (cache[i_][(j_ + 1) % 3][0])
                            {
                                i = i_;
                                j = (j_ + 2) % 3;
                                temp = square[i_][(j_ + 1) % 3];
                            } else
                            {
                                i = i_;
                                j = (j_ + 1) % 3;
                                temp = square[i_][(j_ + 2) % 3];
                            }
                            //直接求解该点的值
                            temp = 15 - temp - square[i_][j_];
                            if (temp <= 9 & temp > 0)
                            {
                                cache[i][j][0] = true;
                                square[i][j] = temp;
                                colModel = true;
                            } else
                            {
                                if (tempLock)
                                {
                                    if (cache[i_][(j_ + 1) % 3][0])
                                    {
                                        cache[i_][(j_ + 1) % 3][0] = false;
                                        tempLock = false;
                                        square[i_][(j_ + 1) % 3] = 0;
                                    } else
                                    {
                                        cache[i_][(j_ + 2) % 3][0] = false;
                                        tempLock = false;
                                        square[i_][(j_ + 2) % 3] = 0;
                                    }
                                    continue;
                                } else return false;
                            }
                        }
                    }
                }
            }
        }
    }

    public static Boolean thricePoint(int[][] square, int i_, int j_, boolean backStateOn)
    {
        boolean flag = twicePoint(square, i_, j_);
        if (!flag) return false;
        else
        {
            int temp;
            if (backStateOn)
            {
                //两点都锁了
                if (cache[(i_ + 1) % 3][(j_ + 2) % 3][0] & cache[(i_ + 2) % 3][(j_ + 4) % 3][0])
                {
                    return !addBackDiagonal(square, i_, j_);
                }
                temp = square[1][1];
                if (cache[2][0][0])
                {
                    if (15 - temp - square[i_][j_] <= 9 & 15 - temp - square[i_][j_] > 0)
                    {
                        square[0][2] = 15 - temp - square[i_][j_];
                        cache[0][2][0] = true;
                        return true;
                    } else return false;
                } else
                {
                    if (15 - temp - square[i_][j_] <= 9 & 15 - temp - square[i_][j_] > 0)
                    {
                        square[2][0] = 15 - temp - square[i_][j_];
                        cache[2][0][0] = true;
                        return true;
                    } else return false;
                }
            } else
            {
                //行两点锁吗
                if (cache[(i_ + 1) % 3][(j_ + 1) % 3][0] & cache[(i_ + 2) % 3][(j_ + 2) % 3][0])
                {
                    return !addDiagonal(square, i_, j_);
                }
                temp = square[1][1];
                if (cache[2][2][0])
                {
                    if (15 - temp - square[i_][j_] <= 9 & 15 - temp - square[i_][j_] > 0)
                    {
                        square[0][0] = 15 - temp - square[i_][j_];
                        cache[0][0][0] = true;
                        return true;
                    } else return false;
                } else
                {
                    if (15 - temp - square[i_][j_] <= 9 & 15 - temp - square[i_][j_] > 0)
                    {
                        square[2][2] = 15 - temp - square[i_][j_];
                        cache[2][2][0] = true;
                        return true;
                    } else return false;
                }
            }
        }
    }

    public static boolean addRow(int[][] square, int i, int j)
    {
        return !(square[i][j] + square[i][(j + 1) % 3] + square[i][(j + 2) % 3] == 15);
    }

    public static boolean addCol(int[][] square, int i, int j)
    {
        return !(square[i][j] + square[(i + 1) % 3][j] + square[(i + 2) % 3][j] == 15);
    }

    public static boolean addDiagonal(int[][] square, int i, int j)
    {
        return !(square[i][j] + square[(i + 1) % 3][(j + 1) % 3] + square[(i + 2) % 3][(j + 2) % 3] == 15);
    }

    public static boolean addBackDiagonal(int[][] square, int i, int j)
    {
        return !(square[i][j] + square[(i + 2) % 3][(j + 1) % 3] + square[(i + 1) % 3][(j + 2) % 3] == 15);
    }

    public static void lock(int[][] square)
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (square[i][j] > 0) cache[i][j][0] = true;
            }
        }
    }

    public static void unlock()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                cache[i][j][0] = false;
            }
        }
    }

    public static void squareReset(int[][] square, int i_, int j_)
    {
        int temp = square[i_][j_];
        unlock();
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                square[i][j] = 0;
                flashPointCache(i, j);
            }
        }
        square[i_][j_] = temp;
        square[1][1] = 5;
        lock(square);
    }

    public static void test(int[][] square)
    {
        while (!checkSquare(square))
        {
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    square[i][j] = random.nextInt(9) + 1;
                }
            }
        }
    }
}
