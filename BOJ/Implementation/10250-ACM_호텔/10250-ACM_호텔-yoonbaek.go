package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

var sc, wr = bufio.NewScanner(os.Stdin), bufio.NewWriter(os.Stdout)

func init() {
	sc.Split(bufio.ScanWords)
}

func main() {
	defer wr.Flush()
	T := scan()

	for i := 0;i < T;i++ {
		H, _, N := scan(), scan(), scan()
		floor := N % H
		room := N / H + 1
		if floor == 0 {
			floor = H
			room--
		}
		fmt.Fprintf(wr, "%d%02d\n", floor, room)
	}
}

func scan() int {
	sc.Scan()
	res, _ := strconv.Atoi(sc.Text()) 
	return res
}
// git commit -m "code: Solve boj 10250 ACM 호텔 (yoonbaek)"