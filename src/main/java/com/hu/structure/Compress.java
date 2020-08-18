package com.hu.structure;

import java.util.Map;

/**
 * @author hutao
 */
public class Compress
{

    public byte[] compress(byte[] data)
    {
        HuffmanCoding huffmanCoding = new HuffmanCoding();
        Map<Byte, String> code = huffmanCoding.huffmanCode(data);
        StringBuilder builder = new StringBuilder();
        for (byte datum : data)
        {
            String s = code.get(datum);
            builder.append(s);
        }

        return getBytes(builder);
    }


    private byte[] getBytes(StringBuilder builder)
    {
        double size = builder.length() / 8.0;
        byte[] arr = new byte[(int) Math.ceil(size)];
        for (int i = 0; i <= arr.length; i += 8)
        {
            String substring = builder.substring(i, i + 8);
            byte parseByte = Byte.parseByte(substring, 2);
            arr[i] = parseByte;
        }
        return arr;
    }


}
