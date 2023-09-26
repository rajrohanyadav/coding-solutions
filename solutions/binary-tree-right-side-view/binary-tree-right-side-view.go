/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
import "fmt"

type Queue struct {
    elements []*TreeNode
    len int
}

func (q *Queue) Push(elem *TreeNode) {
    q.elements = append(q.elements, elem)
    q.len += 1
}

func (q *Queue) Pop() *TreeNode {
    item := q.elements[0]
    q.elements = q.elements[1:]
    q.len -= 1
    return item
}

func (q Queue) Len() int {
    return q.len
}

func rightSideView(root *TreeNode) []int {
    if root == nil {
        return []int{}
    }
    var res []int
    q := Queue{
        elements: []*TreeNode{},
        len: 0,
    }
    q.Push(root)
    numCurrLevel := 0
    for q.Len() > 0 {
        numCurrLevel = q.Len()
        temp := []int{}
        for i:=0; i<numCurrLevel; i++ {
            t := q.Pop()
            temp = append(temp, t.Val)
            if t.Left != nil {q.Push(t.Left)}
            if t.Right != nil {q.Push(t.Right)}
        }
        res = append(res, temp[len(temp)-1])
    }
    return res
}