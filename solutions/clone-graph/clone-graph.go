/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Neighbors []*Node
 * }
 */

func cloneGraph(node *Node) *Node {
    oldToNew := map[*Node]*Node{} 
    if node == nil {
        return nil
    }
    return cloneNode(node, &oldToNew)
}

func cloneNode(n *Node, m *map[*Node]*Node ) *Node {
    if val, ok := (*m)[n]; ok {
        return val
    }
    copy := &Node{
        Val: n.Val,
        Neighbors: []*Node{},
    }
    (*m)[n] = copy
    for _, neighbor := range (*n).Neighbors {
        copy.Neighbors = append(copy.Neighbors, cloneNode(neighbor, m))
    }
    return copy
}