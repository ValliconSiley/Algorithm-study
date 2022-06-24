// git commit -m "code: Solve boj 09375 패션왕 신해빈 (yoonbaek)"
package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

var (
	sc = bufio.NewScanner(os.Stdin)
)

func init() {
	sc.Split(bufio.ScanWords)
}

func main() {
	T, _ := strconv.Atoi(scan())
	
	for i:=0; i < T; i++ {
		n, _ := strconv.Atoi(scan())
		closet := map[string]int{}
		
		for i:=0; i < n; i++ {
			_, category := scan(), scan()
			closet[category] += 1
		}

		cnt := 1
		for _, val := range closet {
			cnt *= (val+1)
		}
		fmt.Println(cnt-1)
	}
}

func scan() string {
	sc.Scan()
	return sc.Text()
}