package main

import "fmt"
// import "runtime"
import "sync"

var wg sync.WaitGroup
var count int = 0
var mutex sync.Mutex
const N = 10000



//https://pkg.go.dev/search?q=runtime 
func main(){
	// fmt.Printf("the NumCPU  %d \n", runtime.NumCPU())
	wg.Add(N)
	for i := 0; i < N; i++ {
		go print("hello world")
	}
	wg.Wait()
	fmt.Println("count is ", count)
}


func print(s string){
	mutex.Lock()
	count = count + 1
	mutex.Unlock()
	// fmt.Println(s)
	wg.Done();
}