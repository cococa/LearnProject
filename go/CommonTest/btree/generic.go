package btree

import "fmt"

type Node[T comparable] struct {
	items []T
	child []Node[T]
}

// Btree
type Btree[T comparable] struct {
	degree int // 每个节点的degree
	length int // 所有元素个数
	root   *Node[T]
}

// 每个节点最多元素
func (t *Btree[T]) maxItems() int {
	return t.degree*2 - 1
}

// 每个节点最少元素
func (t *Btree[T]) minItems() int {
	return t.degree - 1
}

func (t *Btree[T]) Append(item T) (_ T, res bool) {
	if nil == t.root {
		t.root = &Node[T]{
			items: []T{},
			//child: nil
		}
		t.root.items = append(t.root.items, item)
		t.length++

	} else {
		len := len(t.root.items)
		if len >= t.maxItems() {
			// 分裂root 下的节点
			pre, next, parent := t.root.split(t.maxItems() / 2)

			// todo 需要优化
			t.root.items = []T{}
			t.root.child = []Node[T]{}

			t.root.items = append(t.root.items, parent)
			t.root.child = append(t.root.child, pre, next)
		}
		t.root.items = append(t.root.items, item)
		t.length++
	}
	var a T
	return a, true
}

func (node Node[T]) split(i int) (pre, next Node[T], parent T) {

	parentItem := node.items[i]
	preNode := Node[T]{
		items: node.items[:i],
	}

	nextNode := Node[T]{}
	nextNode.items = append(nextNode.items, node.items[i+1:]...)

	if len(node.child) > 0 {
		nextNode.child = append(nextNode.child, node.child[i+1:]...)
		preNode.child = append(preNode.child, node.child[:i]...)
	}

	fmt.Println(parentItem)
	fmt.Println(preNode)
	fmt.Println(nextNode)
	return preNode, nextNode, parentItem
	//nextNode.children = append(next.children, n.children[i+1:]...)

}
