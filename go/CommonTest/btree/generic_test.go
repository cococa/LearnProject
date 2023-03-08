package btree

import (
	"fmt"
	"testing"
)

func Test(t *testing.T) {
	maxLen := 100
	var btree Btree[int]
	btree.degree = 8
	//var node Node[int]
	//node.items = make([]int, 10)
	for i := 0; i < maxLen; i++ {
		btree.Append(i)
	}
	//node.child = make([]Node[int], 2)
	//fmt.Println(node)

	//btree.root = &node

	//btree.root.split(3)

	fmt.Printf("the btree maxItems = %d \n\r", btree.maxItems())
	fmt.Printf("the btree minItems = %d \n\r", btree.minItems())

}
