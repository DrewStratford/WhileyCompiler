type IntList is {int op, real[] rest} | {int[] op, int mode}

function f(IntList x) -> IntList:
    return x

method main() :
    IntList x = {op: 1, rest: [1.23]}
    x.op = [1, 2, 3]
    f(x)
