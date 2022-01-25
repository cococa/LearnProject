package com.cocoa.testjetpack.net

import com.cocoa.testjetpack.bean.CommentModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class CommentsRepository(val apiService: ApiService) {


    suspend fun getComment(id: Int): Flow<CommentApiState<CommentModel>> {
        return flow {

            // get the comment Data from the api
            val comment = apiService.getComments(id)

            // Emit this data wrapped in
            // the helper class [CommentApiState]
            emit(CommentApiState.success(comment))

            val a3 = apiService.getComments(3)
            // Emit this data wrapped in
            // the helper class [CommentApiState]
            emit(CommentApiState.success(a3))

        }.flowOn(Dispatchers.IO)
    }


}