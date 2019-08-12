//See LICENSE for license details.

package dessert
package examples

import chisel3._

class ShiftRegisterIO extends Bundle {
  val in    = Input(UInt(4.W))
  val shift = Input(Bool())
  val out   = Output(UInt(4.W))
}

class ShiftRegister extends Module {
  val io = IO(new ShiftRegisterIO)
  val r0 = RegInit(0.U(4.W))
  val r1 = RegInit(0.U(4.W))
  val r2 = RegInit(0.U(4.W))
  val r3 = RegInit(0.U(4.W))
  when(io.shift) {
    r0 := io.in
    r1 := r0
    r2 := r1
    r3 := r2
  }
  io.out := r3
}
