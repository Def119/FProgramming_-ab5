import scala.io.StdIn._

@main def main() ={
    //part 1
    var productList:List[String]=Nil;
    productList=getProductList(productList);
    // println(productList);

    //part 2
    printProductList(productList);

    // part 3
    println(s"total number of products in the list is: ${getTotalProducts(productList)}");
}

def getTotalProducts(list:List[String]):Int={
    return list.length;    
}

def printProductList(products:List[String]):Unit={
    var n:Int=0;
    println("\nProduct list is :\n");
    for(item <- products){
        println(s"${n+1} :  $item \n");
        n+=1;
    }
}

def getProductList(productList: List[String]):List[String] ={
    println("enter product ('done' to end): ");
    var input = readLine();
    if (input == "done"){
        return productList;
    }else{
        return getProductList(productList :+ input);
    }
}