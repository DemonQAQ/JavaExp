package Lzh0234.ex4;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Random;

/*
 * JavaExp Lzh0234.ex4
 * @Author:Demon
 * @Date:2021/11/5 17:18
 * @Description:
 */
public class ThreeStageMagicSquare
{
    //0号位作锁变量
    private static boolean[][][] cache = new boolean[3][3][10];
    private static Random random = new Random();


    public static void create(int[][]square ,int i_,int j_)
    {
        boolean flag=false;
        if ((i_+j_)%2==1)
        {
            while (!flag)
            {
                ThreeStageMagicSquare.lock(square);
                twicePoint(square,i_,j_);
                ThreeStageMagicSquare.lock(square);
                flag = thricePoint(square,0,0,false);
                if (!flag)
                {
                    squareReset(square,i_,j_);
                    unlock();
                }
                else
                {
                    ThreeStageMagicSquare.lock(square);
                    flag = thricePoint(square,0,2,true);
                    if (!flag)
                    {
                        squareReset(square,i_,j_);
                        unlock();
                    }
                    else
                    {
                        if (!testa(square))flag=true;
                        else
                        {
                            squareReset(square,i_,j_);
                            unlock();
                        }

                    }
                }
            }


        }
    }

    public static boolean testa(int[][] square)
    {
        if (addRow(square, 0, 0)) return true;
        if (addRow(square, 1, 0)) return true;
        if (addRow(square, 2, 0)) return true;
        if (addCol(square, 0, 0)) return true;
        if (addCol(square, 0, 1)) return true;
        if (addCol(square, 0, 2)) return true;
        if (addBackDiagonal(square, 0, 2)) return true;
        if (addDiagonal(square, 0, 0)) return true;
        return false;
    }

    public static void test(int[][] square)
    {
        while (testa(square))
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
        int times = 0, i = i_, j = j_;
        cache[1][1][0] = true;
        while (addRow(square, i_, j_) || addCol(square, i_, j_))
        {
            if (square[i_][j_] == 0)
            {
                if (square[(i_ + 1) % 3][j_] > 0 && square[(i_ + 2) % 3][j_] > 0)
                {
                    if (square[(i_ + 1) % 3][j_] + square[(i_ + 2) % 3][j_] >= 15 || square[i_][(j_ + 1) % 3] + square[i_][(j_ + 2) % 3] >= 15)
                        return false;
                    else
                    {
                        do
                        {
                            if (checkPointCacheFull(i_, j_)) return false;
                            square[i_][j_] = getRandomNum(i_, j_);
                        } while (addRow(square, i_, j_) || addCol(square, i_, j_));
                    }
                } else
                {
                    do
                    {
                        if (checkPointCacheFull(i_, j_)) return false;
                        square[i_][j_] = getRandomNum(i_, j_);
                    } while (!addRow(square, i_, j_) || !addCol(square, i_, j_));

                }
            } else
            {
                //终止条件，第一个生成点的缓存全满则生成失败
                if (checkPointCacheFull(i_, (j_ + 1) % 3)) return false;
                if (checkPointCacheFull(i, j))
                {
                    flashPointCache(i, j);
                    if (times == 3)
                    {
                        i = (i + 2) % 3;
                        j = (j_ + 2) % 3;
                        square[i][j] = 0;
                        times -= 2;
                    } else times--;
                    if (times == 1) j = (j + 2) % 3;
                    if (times == 3) i = (i + 2) % 3;
                } else
                {
                    if (times < 2)
                    {
                        //在if内的变量值位置为待生成位置
                        j = (j + 1) % 3;
                        times++;
                        if (times == 1)
                        {
                            if (cache[i][j][0])
                            {
                            } else
                            {
                                if (square[i_][j_]>0&&square[i][(j+1)%3]>0&&15-square[i_][j_]-square[i][(j+1)%3]<=9&&15-square[i_][j_]-square[i][(j+1)%3]>0)
                                    square[i][j]=15-square[i_][j_]-square[i][(j+1)%3];
                                else
                                {
                                    do
                                    {
                                        square[i][j] = getRandomNum(i, j);
                                    } while (square[i_][j_] + square[i][j] > 15);
                                }
                            }
                        } else
                        {
                            if (cache[i][j][0] && square[i_][j_] > 0 && square[(i_ + 1) % 3][j_] > 0 && square[(i_ + 2) % 3][j_] > 0 && addRow(square, i_, j_))
                            {
                                square[i_][(j_ + 1) % 3] = 0;
                                j = j_;
                                times = 0;
                            } else
                            {
                                if (square[i_][j_]>0&&square[i][(j+1)%3]>0&&15-square[i_][j_]-square[i][(j+1)%3]<=9&&15-square[i_][j_]-square[i][(j+1)%3]>0)
                                    square[i][j]=15-square[i_][j_]-square[i][(j+1)%3];
                                else
                                {
                                    while (addRow(square, i_, j_))//行未满时循环
                                    {
                                        if (cache[i][j][0] || 15 - square[i_][(j_ + 1) % 3] - square[i_][j_] > 9 || checkPointCacheFull(i, j))
                                        {
                                            times = 0;
                                            square[i][(j + 2) % 3] = 0;
                                            i = i_;
                                            j = j_;
                                            break;
                                        }
                                        square[i][j] = getRandomNum(i, j);
                                    }
                                }

                            }
                        }
                    }
                    if (times >= 2 & times < 4)
                    {
                        j = j_;
                        i = (i + 1) % 3;
                        times++;
                        if (times == 3)
                        {
                            if (cache[i][j][0])
                            {
                            } else
                            {
                                if (square[i_][j_]>0&&square[(i+1)%3][j]>0&&15-square[i_][j_]-square[(i+1)%3][j]<=9&&15-square[i_][j_]-square[(i+1)%3][j]>0)
                                    square[i][j]=15-square[i_][j_]-square[(i+1)%3][j];
                                else
                                {
                                    do
                                    {
                                        square[i][j] = getRandomNum(i, j);
                                    } while (square[i_][j_] + square[i][j] > 15);
                                }
                            }
                        } else
                        {
                            if (square[i][j] > 0 && cache[i][j][square[i][j]])
                            {
                                if (cache[i][j][0] && square[i_][j_] > 0 && square[(i_ + 1) % 3][j_] > 0 && square[(i_ + 2) % 3][j_] > 0 && addCol(square, i_, j_))
                                {
                                    square[(i_ + 1) % 3][j_] = 0;
                                    i = i_;
                                    times = 2;
                                }
                            } else
                            {
                                if (square[i_][j_]>0&&square[(i+1)%3][j]>0&&15-square[i_][j_]-square[(i+1)%3][j]<=9&&15-square[i_][j_]-square[(i+1)%3][j]>0)
                                    square[i][j]=15-square[i_][j_]-square[(i+1)%3][j];
                                else
                                {
                                    while (addCol(square, i_, j_))
                                    {
                                        if (cache[i][j][0] || 15 - square[(i_ + 1) % 3][j_] - square[i_][j_] > 9 || checkPointCacheFull(i, j))
                                        {
                                            times = 2;
                                            square[(i + 2) % 3][j] = 0;
                                            i = i_;
                                            break;
                                        }
                                        square[i][j] = getRandomNum(i, j);
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
        return true;
    }
    public static boolean twicePoint_(int[][] square, int i_, int j_)
    {
        int temp,i,j;
        //初始点未有值
        while (true)
        {
            if (square[i_][j_]==0)
            {
                //行另外两点是否被锁
                if (cache[i_][(j_+1)%3][0]&&cache[i_][(j_+2)%3][0])
                {
                    //两锁时检查列是否被锁两点
                    if (cache[(i_+1)%3][j_][0]&&cache[(i_+2)%3][j_][0])
                    {
                        if ((15-square[i_][(j_+1)%3]-square[i_][(j_+2)%3])==(15-square[(i_+1)%3][j_]-square[(i_+2)%3][j_]))
                        {
                            cache[i_][j_][0]=true;
                            square[i_][j_]=15-square[i_][(j_+1)%3]-square[i_][(j_+2)%3];
                        }
                        else return false;
                    }
                    else
                    {
                        cache[i_][j_][0]=true;
                        square[i_][j_]=15-square[i_][(j_+1)%3]-square[i_][(j_+2)%3];
                    }
                }
                else
                {
                    //行两点都没锁，直接生成
                    if (!cache[i_][(j_+1)%3][0]&!cache[i_][(j_+2)%3][0])square[i_][j_]=
                            getRandomNum(i_,j_);
                        //行锁了一点，根据锁的点确定生成的可行范围
                    else
                    {

                        if (cache[i_][(j_+1)%3][0])temp = square[i_][(j_+1)%3];
                        else temp = square[i_][(j_+2)%3];
                        cache[i_][j_][0]=true;
                        do
                        {
                            if (checkPointCacheFull(i_,j_))return false;
                            square[i_][j_]=getRandomNum(i_,j_);
                        }while (15-temp-square[i_][j_]>9);
                    }
                }
            }
            //初始点有值
            else
            {
                boolean colModel=false;
                boolean tempLock=false;
                while (true)
                {
                    //列模式
                    if (colModel)
                    {
                        //整列都被封锁，此时行应是满的
                        if (cache[i_][j_][0]&&cache[(i_+1)%3][j_][0]&&cache[(i_+2)%3][j_][0])
                        {
                            if (!addRow(square,i_,j_)&!addCol(square, i_, j_))return true;
                            else return false;
                        }

                    }
                    //行模式
                    else
                    {
                        //整行都被封锁
                        if (cache[i_][j_][0]&&cache[i_][(j_+1)%3][0]&&cache[i_][(j_+2)%3][0])
                        {
                            //addRow检测一行为15时返回false
                            if (!addRow(square,i_,j_))
                            {
                                colModel=true;
                                continue;
                            }
                            else return false;
                        }
                    }
                    //行或列未被完全封锁时到此处
                    //确定是两个点都没锁还是只锁了一个点
                    //当前为列模式
                    if (colModel)
                    {
                        //给定点周围两个都没被封锁
                        if (!cache[(i_+1)%3][j_][0]&!cache[(i_+2)%3][j_][0])
                        {
                            i=(i_+1)%3;
                            j=j_;
                            cache[i][j][0]=true;
                            tempLock=true;
                            do
                            {
                                if(checkPointCacheFull(i,j))return false;
                                square[i][j]=getRandomNum(i,j);
                            }while (15-square[i_][j_]-square[i][j]>9);
                        }
                        //封锁了其中一个点
                        else
                        {
                            //此时给定点和封锁点一共两个点被封锁
                            if (cache[(i_+1)%3][j_][0])
                            {
                                i=(i_+2)%3;
                                j=j_;
                                temp=square[(i_+1)%3][j_];
                            }
                            else
                            {
                                i=(i_+1)%3;
                                j=j_;
                                temp=square[(i_+2)%3][j_];
                            }
                            //直接求解该点的值
                            temp=15-temp-square[i_][j_];
                            if (temp<=9&temp>0)
                            {
                                cache[i][j][0]=true;
                                square[i][j]=temp;
                                return true;
                            }
                            else
                            {
                                if (tempLock)
                                {
                                    if (cache[(i_+1)%3][j_][0])
                                    {
                                        cache[(i_+1)%3][j_][0]=false;
                                        tempLock=false;
                                        square[(i_+1)%3][j_]=0;
                                    }
                                    else
                                    {
                                        cache[(i_+2)%3][j_][0]=false;
                                        tempLock=false;
                                        square[(i_+2)%3][j_]=0;
                                    }
                                    continue;
                                }
                                else return false;
                            }
                        }

                    }
                    //行模式
                    else
                    {
                        //给定点周围两个都没被封锁
                        if (!cache[i_][(j_+1)%3][0]&!cache[i_][(j_+2)%3][0])
                        {
                            i=i_;
                            j=(j_+1)%3;
                            cache[i][j][0]=true;
                            tempLock=true;
                            do
                            {
                                if (checkPointCacheFull(i,j))return false;
                                square[i][j]=getRandomNum(i,j);
                            }while (15-square[i_][j_]-square[i][j]>9);
                        }
                        //封锁了其中一个点
                        else
                        {
                            //此时给定点和封锁点一共两个点被封锁
                            if (cache[i_][(j_+1)%3][0])
                            {
                                i=i_;
                                j=(j_+2)%3;
                                temp=square[i_][(j_+1)%3];
                            }
                            else
                            {
                                i=i_;
                                j=(j_+1)%3;
                                temp=square[i_][(j_+2)%3];
                            }
                            //直接求解该点的值
                            temp=15-temp-square[i_][j_];
                            if (temp<=9&temp>0)
                            {
                                cache[i][j][0]=true;
                                square[i][j]=temp;
                                colModel=true;
                            }
                            else
                            {
                                if (tempLock)
                                {
                                    if (cache[i_][(j_+1)%3][0])
                                    {
                                        cache[i_][(j_+1)%3][0]=false;
                                        tempLock=false;
                                        square[i_][(j_+1)%3]=0;
                                    }
                                    else
                                    {
                                        cache[i_][(j_+2)%3][0]=false;
                                        tempLock=false;
                                        square[i_][(j_+2)%3]=0;
                                    }
                                    continue;
                                }
                                else return false;
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
        if (squareIsFull(square))
        {
            if (testa(square))return false;
            else return true;
        }
        int times = 0, i = i_, j = j_;
        if (!flag) return false;
        flag = !selectAddDiagonal(square,i_,j_,backStateOn);
        if (flag&&cache[(i_+1)%3][(j+1)%3][0]&&cache[(i_+2)%3][(j+2)%3][0])return false;
        else
        {
            while (selectAddDiagonal(square,i_,j_,backStateOn))
            {
                times++;
                i = (i + 1) % 3;
                j = (j + 1) % 3;
                if (times == 1)
                {
                    if (cache[i][j][0])
                    {
                    } else
                    {
                        do
                        {
                            if (checkPointCacheFull(i,j))return false;
                            square[i][j] = getRandomNum(i, j);
                        } while (square[i_][j_] + square[i][j] > 15);
                    }
                }
                if (times == 2)
                {
                    do
                    {
                        if (checkPointCacheFull(i,j))return false;
                        square[i][j] = getRandomNum(i, j);
                    } while (selectAddDiagonal(square, i_, j_, backStateOn));
                }

            }
        }

        return true;
    }

    public static Boolean thricePoint_(int[][] square, int i_, int j_, boolean backStateOn)
    {
        return false;
    }

    public static boolean selectAddDiagonal(int[][] square,int i_,int j_,boolean backStateOn)
    {
        if (backStateOn)
        {
            return (addBackDiagonal(square, i_, j_));
        } else
        {
            return (addDiagonal(square, i_, j_));
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

    public static boolean squareIsFull(int[][] square)
    {
        for (int i=0;i<3;i++)
        {
            for (int j=0;j<3;j++)
            {
                if (square[i][j]==0)return false;
            }
        }
        return true;
    }

    public static void squareReset(int[][] square,int i_,int j_)
    {
        int temp = square[i_][j_];
        for (int i=0;i<3;i++)
        {
            for (int j=0;j<3;j++)
            {
                square[i][j]=0;
                flashPointCache(i,j);
            }
        }
        square[i_][j_]=temp;
        square[1][1]=5;
    }
}
