package com.coco.test

class IrDataUtil {

    companion object {

        fun subRespByteArray(request: ByteArray, response: ByteArray): ByteArray? {

            if (request.size == 0 || response.size == 0) {
                return null
            }

            val size = response.size - request.size
            var resultByteArry: ByteArray? = null

            if (size > 0) {

                resultByteArry = ByteArray(size)

                for ((index, value) in response.withIndex()) {
                    if (index < request.size) {
                        if (request.get(index) != response.get(index)) {
                            resultByteArry = null
                            break
                        }
                    } else {
                        resultByteArry?.set(index - size, value)
                    }
                }
            }

            return resultByteArry
        }
    }


}