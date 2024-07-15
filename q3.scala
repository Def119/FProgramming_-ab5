
@main def main ={
    // println(s"${fib(4)}");
    
    // println(s"${fib(5)}");

    fibSeq(6);
}

def fibSeq(n:Int,curr: Int =0):Unit ={
    if(curr <= n){
        println(s"${fib(curr)} \t");
        fibSeq(n,curr+1);
    }
}

def fib(n:Int):Int={
    if (n<0){
        return 0;
    }else if(n==1 ){
        return 1;
    }else {
        return fib(n-1) + fib(n-2);
    }
}