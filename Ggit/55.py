import numpy as np
import random as rd

"""计算染色体对应的路线总长"""
def countlen(chromo, distance, cityNum):
    len = 0
    for iii in range(cityNum - 1):
        len += distance[chromo[iii]][chromo[iii + 1]]
    len += distance[chromo[cityNum - 1]][chromo[0]]  # 加上返回起点的距离
    return len

"""生成初始种群"""
def crepopula(cityNum, M):
    popula = []  # 种群
    for ii in range(M):
        chromo = np.random.permutation(cityNum)  # 染色体
        popula.append(chromo)
    return popula

"""计算种群中每个个体的累积概率"""
def countprobabily(popula,distance,cityNum):
    evall = []
    for chromo in popula:
        eval = 10 - countlen(chromo, distance,cityNum)  # 适应值函数
        evall.append(eval)
    seval = sum(evall)
    probabil = evall/seval   #单个概率
    probabily = probabil.copy()
    for i in range(1,len(popula)):
        probabily[i]=probabily[i]+probabily[i-1]  #累积概率
    return probabily

"""轮盘挑选子代"""
def lpd(popula,probabily,M):
    newpopula=[]
    for i in range(M):
        proba = rd.random()
        for ii in range(len(probabily)):
            if probabily[ii] >= proba:
                selechromo = popula[ii]
                break
        newpopula.append(selechromo)
    return newpopula

"""顺序交叉"""
def crossover(father1, father2,cityNum):
    ord1 = rd.randint(0, cityNum)
    ord2 = rd.randint(0, cityNum)
    if ord1 == ord2:
        son = father1
    elif ord1 < ord2:
        son = ox(father1, father2, ord1, ord2)
    else:
        son = ox(father1, father2, ord2, ord1)
    return son

def ox(father1, father2, ord1, ord2):  # 顺序交叉
    son1 = father1[ord1:ord2]  # 继承父代1
    son2 = []
    for gene in father2:
        if gene not in son1:
            son2.append(gene)  # 继承父代2
    for i in range(len(son1)):  # 插入
        son2.insert(ord1, son1[len(son1) - i - 1])
    return son2

"""互换变异"""
def variat(father,cityNum):
    or1 = rd.randint(0, cityNum-1)
    or2 = rd.randint(0, cityNum-1)
    son = father.copy()
    son[or1] = father[or2]
    son[or2] = father[or1]
    return son


def main():
    M = 20  # 种群规模
    cityNum = 8  # 城市数量，染色体长度
    """生成坐标"""
    cities = np.random.randint(0,10,size=[8,2])
    print(cities)
    """生成矩阵"""
    distance = np.zeros([cityNum, cityNum])
    for i in range(cityNum):
        for j in range(cityNum):
            distance[i][j] = pow((pow(cities[i][0] - cities[j][0], 2) + pow(cities[i][1] - cities[j][1], 2)), 0.5)
    #print(distance)

    """初始化"""
    popula = crepopula(cityNum, M)

    for n in range(2000):  #循环次数
        """进化"""
        pc = 0.8  # 交叉率
        pv = 0.2  # 变异率
        son = []
        crossgroup = []
        for i in range(M):
            cpb = rd.random()
            if cpb < pc:  # 小于交叉率的进行交叉
                crossgroup.append(popula[i])
        if len(crossgroup) % 2 == 1:  # 如果奇数个
            del crossgroup[-1]
        if crossgroup != []:  # 顺序交叉
            for ii in range(0, len(crossgroup), 2):
                sonc = crossover(crossgroup[ii], crossgroup[ii + 1], cityNum)
                son.append(sonc)
       
        ##互换变异
        variatgroup = []
        for j in range(M):
            vpb = rd.random()
            if vpb < pv:  # 小于变异率的进行变异
                variatgroup.append(popula[j])
        if variatgroup != []:
            for vag in variatgroup:
                sonv = variat(vag, cityNum)
                son.append(sonv)
       

        """计算每个染色体的累积概率"""
        populapuls = popula + son
        probabily = countprobabily(populapuls, distance, cityNum)

        """轮盘赌选择新种群"""
        popula = lpd(populapuls, probabily, M)

    #print(popula)
    """挑选最好的染色体"""
    opt_chr = popula[0]
    opt_len = countlen(popula[0], distance, cityNum)
    for chr in popula:
        chrlen = countlen(chr, distance, cityNum)
        if chrlen < opt_len:
            opt_chr = chr
            opt_len = chrlen
    print("最优路径: "+str(opt_chr))
    print("最优值"+str(opt_len))


if __name__ == "__main__":
    main()
