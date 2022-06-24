// git commit -m "code: Solve boj 01012 유기농 배추 (yoonbaek)"

package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

var (
	sc = bufio.NewScanner(os.Stdin)
	row, col, baechoos int
	field = [][]int{}
	L, R, U, D = loc{0, -1}, loc{0, 1}, loc{-1, 0}, loc{1, 0}
	DIR = []loc{L, R, U, D}
)
//
type loc struct {
	x, y int
}

// Queue
type Queue chan loc
func (q *Queue) push(v loc) { *q <- v }
func (q *Queue) popLeft() loc { return <-*q }
func (q Queue) isEmpty() bool { return len(q) == 0 }

func init() {
	sc.Split(bufio.ScanWords)
}

func main() {
	T := scan()

	for i := 0; i < T; i++ {
		col, row, baechoos = scan(), scan(), scan()
		field = make([][]int, row)

		for r := range field {
			field[r] = make([]int, col)
		}

		for baechoos > 0 {
			x, y := scan(), scan()
			field[y][x] = 1
			baechoos--
		}
		
		fmt.Println(bugCnt())
	}
}

func scan() int {
	sc.Scan()
	res, _ := strconv.Atoi(sc.Text())
	return res
}

func bugCnt() int {
	cnt := 0
	for r := range field {
		for c := range field[r] {
			cnt += bfs(r, c)
		}
	}
	return cnt
}

func outOfBound(x, y int) bool {
	return !(x >= 0 && x < col && y >= 0 && y < row)
}

func bfs(r, c int) int {
	if field[r][c] == 1 {
		field[r][c] = 0
		q := make(Queue, row*col)
		s := loc{x: c, y: r}
		q.push(s)

		for !q.isEmpty() {
			now := q.popLeft()
			for _, dir := range DIR {
				x, y := now.x + dir.x, now.y + dir.y
				// fmt.Println("now:", x, y, outOfBound(x, y))
				if outOfBound(x, y) || field[y][x] == 0 {
					continue
				}
				field[y][x] = 0
				q.push(loc{x: x, y: y}) 
			}
		}
		return 1
	}
	return 0
}
// [[1 0 0 0 0 0 0 0 0 0]
//  [0 1 0 0 0 0 0 0 0 0] [0 0 0 0 0 0 0 0 0 0] [0 0 0 0 1 0 0 0 0 0] [0 0 1 1 0 0 0 0 0 0] [0 0 0 0 1 0 0 0 0 0] [0 0 0 0 0 0 0 1 1 1] [0 0 0 0 0 0 0 0 0 0]]

// [[0 0 0 0 0 0 0 0 0 0]
//  [0 0 0 0 0 0 0 0 0 0] 
//  [0 0 0 0 0 0 0 0 0 0] 
//  [0 0 0 0 0 0 0 0 0 0] 
//  [0 0 0 0 0 0 0 0 0 0] 
//  [0 0 0 0 0 1 0 0 0 0] 
//  [0 0 0 0 0 0 0 0 0 0] 
//  [0 0 0 0 0 0 0 0 0 0] 
//  [0 0 0 0 0 0 0 0 0 0] 
//  [0 0 0 0 0 0 0 0 0 0]]