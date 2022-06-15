package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

type Queue struct {
	index []int
	rank  []int
	size  int
}

func (q *Queue) Push(index, rank int) {
	q.index = append(q.index, index)
	q.rank = append(q.rank, rank)
	q.size++
}

func (q *Queue) Pop() (int, int) {
	index := q.index[0]
	rank := q.rank[0]
	q.index = q.index[1:]
	q.rank = q.rank[1:]
	q.size--
	return index, rank
}

var (
	c, n, m int
	sc      *bufio.Scanner
	wr      *bufio.Writer
)

func init() {
	sc = bufio.NewScanner(os.Stdin)
	wr = bufio.NewWriter(os.Stdout)
}

func main() {
	defer wr.Flush()
	if sc.Scan() {
		c, _ = strconv.Atoi(sc.Text())
	}
	for i := 0; i < c; i++ {
		if sc.Scan() {
			fields := strings.Fields(sc.Text())
			n, _ = strconv.Atoi(fields[0])
			m, _ = strconv.Atoi(fields[1])
			q := Queue{index: make([]int, n),
				rank: make([]int, n)}
			memory := [10]int{}
			sorted := Queue{index: []int{}, rank: []int{}}
			if sc.Scan() {
				fields := strings.Fields(sc.Text())
				for i := 0; i < n; i++ {
					q.index[i] = i
					q.rank[i], _ = strconv.Atoi(fields[i])
					memory[q.rank[i]]++
				}
				q.size = n
			}

			for r := 9; r > 0; r-- {
				v := q.size
				for i := 0; i < v; i++ {
					if memory[r] > 0 {
						idx, rank := q.Pop()
						if rank < r {
							q.Push(idx, rank)
						} else {
							memory[r]--
							sorted.Push(idx, rank)
						}
					}
				}
			}
			for i := 0; i < n; i++ {
				if sorted.index[i] == m {
					fmt.Fprintln(wr, i+1)
				}
			}
		}
	}
}