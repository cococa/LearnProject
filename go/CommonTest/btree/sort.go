package btree

import (
	"fmt"
	"sort"
)

func Sort() {
	a := 10
	result := sort.Search(100, func(i int) bool {
		fmt.Println(i)
		return a < i
	})

	fmt.Printf("\rresult = %d ", result)

}