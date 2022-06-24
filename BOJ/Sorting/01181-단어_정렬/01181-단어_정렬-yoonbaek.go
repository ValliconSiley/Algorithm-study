// git commit -m "code: Solve boj 01181 단어 정렬 (yoonbaek)"
package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
	"strconv"
)

var sc = bufio.NewScanner(os.Stdin)
var wr = bufio.NewWriter(os.Stdout)

func init() {
	sc.Split(bufio.ScanLines)
}

type Words []string

func (a Words) Len() int           { return len(a) }
func (a Words) Swap(i, j int)      { a[i], a[j] = a[j], a[i] }
func (a Words) Less(i, j int) bool { return criterion(a[i], a[j]) }

func main() {
	defer wr.Flush()
	sc.Scan()
	T, _ := strconv.Atoi(sc.Text())
	words := make(Words, T)

	for i:=0; i<T; i++ {
		words[i] = scan()
	}
	sort.Sort(words)

	prev := ""
	for i:=0; i<T; i++ {
		if words[i] == prev {
			continue
		}
		fmt.Fprintln(wr, words[i])
		prev = words[i]
	}
}

func scan() string {
	sc.Scan()
	return sc.Text()
}

func criterion(word1, word2 string) bool {
	if len(word1) == len(word2) {
		return word1 < word2
	}
	return len(word1) < len(word2)
}