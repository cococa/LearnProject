package com.cocoa.testjetpack.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cocoa.testjetpack.bean.CommentModel
import com.cocoa.testjetpack.net.AppConfig
import com.cocoa.testjetpack.net.CommentApiState
import com.cocoa.testjetpack.net.CommentsRepository
import com.cocoa.testjetpack.net.Status
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.launch

class CommentsViewModel :ViewModel() {

    val repository = CommentsRepository(AppConfig.ApiService())

    var commentState = MutableStateFlow(
        CommentApiState(
            Status.LOADING,
            CommentModel(), ""
        )
    )

    fun getComments(id: Int){
        viewModelScope.launch {
              repository.getComment(id)
                  .onCompletion {

                  }
                  .catch {

                  }
                  .collect {
                  commentState.tryEmit(it)
              }
        }
    }


}