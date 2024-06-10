package com.example;

//import sun.misc.Unsafe;
//import java.lang.reflect.Field;
//

// we will accesss the memory address of the object, since the protection mechanism of java does not provide direct memory access we are
// going to use the Unsafe class to write our program
// we are also using the reflecitons to get the things at the runtime.


//public class MemoryAddress {
//
//        private static Unsafe getUnsafe() throws Exception {
//            Field f = Unsafe.class.getDeclaredField("theUnsafe");
//            f.setAccessible(true);
//            return (Unsafe) f.get(null);
//        }
//
//        public static void main(String[] args) throws Exception {
//            Unsafe unsafe = getUnsafe();
//            String test = "Hello, World!";
//            long address = getObjectAddress(test, unsafe);
//            System.out.println("Memory address: " + address);
//        }
//
//        private static long getObjectAddress(Object obj, Unsafe unsafe) throws Exception {
//            Object[] array = new Object[]{obj};
//            long baseOffset = unsafe.arrayBaseOffset(Object[].class);
//            return unsafe.getLong(array, baseOffset);
//        }
//    }

//import java.nio.ByteBuffer;
//import java.nio.ByteOrder;
//
//public class MemoryAddress {
//    public static void main(String[] args) {
//        ByteBuffer buffer = ByteBuffer.allocateDirect(8).order(ByteOrder.nativeOrder());
//        buffer.putInt(0, 123456);
//        buffer.putInt(4, 789012);
//
//        long address = ((sun.nio.ch.DirectBuffer) buffer).address();
//        System.out.println("Memory address: " + Long.toHexString(address));
//
//        int value1 = buffer.getInt(0);
//        int value2 = buffer.getInt(4);
//
//        System.out.println("Value 1: " + value1);
//        System.out.println("Value 2: " + value2);
//    }
//}

// the packages have been restricted and are not allowed for production code.


import com.sun.jna.Memory;
import com.sun.jna.Pointer;

public class MemoryAddress {
    public static void main(String[] args) {
        Memory memory = new Memory(8);  // Allocate 8 bytes of memory
        memory.setInt(0, 123456);       // Set an integer at the start
        memory.setInt(4, 789012);       // Set another integer at offset 4

        Pointer pointer = memory.share(0);
        long address = Pointer.nativeValue(pointer);
        System.out.println("> "+address);
        System.out.println("Memory address: " + Long.toHexString(address));

        int value1 = memory.getInt(0);
        int value2 = memory.getInt(4);

        System.out.println("Value 1: " + value1);
        System.out.println("Value 2: " + value2);
    }
}
