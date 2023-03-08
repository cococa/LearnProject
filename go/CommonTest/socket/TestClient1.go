package socket

import (
	"fmt"
	"io/ioutil"
	"net"
)

const (
	SERVER string = ":8080"
)

func te1() {
	tcpAddr, _ := net.ResolveTCPAddr("tcp", SERVER)

	conn, _ := net.DialTCP("tcp", nil, tcpAddr)

	msg, _ := ioutil.ReadAll(conn)

	fmt.Println(string(msg))

}
