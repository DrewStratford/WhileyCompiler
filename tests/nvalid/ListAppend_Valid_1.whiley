import println from whiley.lang.System

method main(System.Console sys) => void:
    r = [1, 2] + [3, 4]
    sys.out.println(Any.toString(r))