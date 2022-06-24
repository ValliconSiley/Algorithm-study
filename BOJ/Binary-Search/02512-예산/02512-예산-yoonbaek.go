// git commit -m "code: Solve boj 02512 예산 (yoonbaek)"
package main

import (
	"bufio"
	"os"
	"strconv"
)

var sc = bufio.NewScanner(os.Stdin)

func init() {
	sc.Split(bufio.ScanWords)
}

func main() {
	N := scan()
	budgets := make([]int, N)

	for i:=0; i<N; i++ {
		budgets[i] = scan()
	}

	totalBudget := scan()
	
}

func scan() int {
	sc.Scan()
	res, _ := strconv.Atoi(sc.Text())
	return res
}