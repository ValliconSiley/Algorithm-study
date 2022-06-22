// git commit -m "code: Solve boj 09372 상근이의여행 (yoonbaek)"
package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

var sc = bufio.NewScanner(os.Stdin)
var wr = bufio.NewWriter(os.Stdout)

func init() {
	sc.Split(bufio.ScanWords)
}

func main() {
	defer wr.Flush()
	T := scan()

	for i:=0; i<T; i++ {
		N, M := scan(), scan()

		for j:=0; j<M; j++ {
			scan()
			scan()
		}
		fmt.Fprintln(wr, N-1)
	}
}

func scan() int {
	sc.Scan()
	res, _ := strconv.Atoi(sc.Text())
	return res
}