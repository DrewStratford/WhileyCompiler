define Rtypes as {int x, int y}|{int x, int y, int z}

string f(Rtypes e):
    if e is {[int] x}:
        return "GOT IT"
    else:
        return "NOPE"

void System::main([string] args):
    this.out.println(f({x: 1, y: 1}))
    this.out.println(f({x: 1, y:1, z: 1}))
