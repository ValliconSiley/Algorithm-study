// git commit -m "code: Solve boj 01260 DFS와 BFS (yoonbaek)"

package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

const MAX = 1000

var (
	sortMemory = make([]int, MAX)
	sc = bufio.NewScanner(os.Stdin)
	graph = map[int][]int{}
	visited = make([]int, 0)
	bfsAns, dfsAns = "", ""
)

type Queue chan int

func (q *Queue) push(v int) { *q <- v }

func (q *Queue) pop() int { return <- *q}

func init() {
	sc.Split(bufio.ScanWords)
}

func main() {
	N, M, V := scan(), scan(), scan()
	visited = make([]int, N)

	for i := 0; i < M; i++ {
		start, end := scan(), scan()
		graph[start] = append(graph[start], end)
		graph[end] = append(graph[end], start)
	}
	
	for idx := range graph {
		graph[idx] = countSort(graph[idx])
	}

	dfs(V)
	visited = make([]int, N)
	bfs(V)
	fmt.Println(bfsAns)
	fmt.Println(dfsAns)
}

func scan() int {
	sc.Scan()
	res, _ := strconv.Atoi(sc.Text())
	return res
}

func countSort(input []int) []int {
	defer reset()
	sorted := []int{}
	for _, val := range input {
		sortMemory[val] = 1
	}
	for idx, val := range sortMemory {
		if val == 0 {
			continue
		}
		sorted = append(sorted, idx)
	}
	return sorted
}

func reset() {
	sortMemory = make([]int, 10)
}

func dfs(V int) {
	dfsAns += fmt.Sprintf("%d ", V)
	visited[V-1] = 1

	for _, val := range graph[V] {
		if visited[val-1] == 1 {
			continue
		}
		dfs(val)
	}
}

func bfs(V int) {
	q := make(Queue, MAX)
	q.push(V)
	visited[V-1] = 1

	for len(q) > 0 {
		now := q.pop()
		bfsAns += fmt.Sprintf("%d ", now)

		for _, val := range graph[now] {
			vIdx := val-1
			if visited[vIdx] == 1 {
				continue
			}
			visited[vIdx] = 1
			q.push(val)
		}
	}
}