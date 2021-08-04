#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    char *buffer;
    size_t buffer_length;
    size_t input_length;
} InputBuffer;

void close_input_buffer(InputBuffer *input_buffer) {
    free(input_buffer->buffer);
    free(input_buffer);
}

typedef enum {
    PREPARE_SUCCESS,
    PREPARE_UNKNOW,
} PreparResult;

typedef enum {
    STATEMENT_INSERT,
    STATEMENT_SELECT
} StatementType;


typedef struct {
    StatementType type;
} Statement;

Statement *preparStatement(InputBuffer *inputBuffer) {
    Statement *statement = (Statement *) malloc(sizeof(Statement));
    if (strncmp(inputBuffer->buffer, "insert",6)== 0) {
        statement->type = STATEMENT_INSERT;
    }else if (strncmp(inputBuffer->buffer, "select",6)== 0) {
        statement->type = STATEMENT_SELECT;
    }  else {
        return NULL;
    }
    return statement;
}

int main() {

    printf("SQLcc is started!\n");
    InputBuffer *inputBuffer = (InputBuffer *) malloc(sizeof(InputBuffer));
    if (!inputBuffer->buffer) {
        printf("the buffer is not malloc \n");
    }
    while (1 == 1) {

        //geline 第一个参数 指向存放该行字符的指针，如果是NULL，则有系统帮助malloc，请在使用完成后free释放。
        //geline 第二个参数 如果是由系统malloc的指针，请填0
        size_t bytes_read = getline(&(inputBuffer->buffer), &(inputBuffer->buffer_length), stdin);

        if (bytes_read <= 0) {
            close_input_buffer(inputBuffer);
            printf("Error reading input\n");
            exit(EXIT_FAILURE);
        }
        inputBuffer->input_length = bytes_read;
        inputBuffer->buffer[bytes_read - 1] = 0;

        if (strcmp(inputBuffer->buffer, ".exit") == 0) {
            printf("SQLcc will exit!\n");
            close_input_buffer(inputBuffer);
            exit(EXIT_SUCCESS);
        } else {

            Statement *statement = preparStatement(inputBuffer);
            if(statement == NULL){
                printf("SQLcc Command not found !\n");
            }else{
                printf("SQLcc Command %d !\n",statement->type);
            };
        }
    }

    return EXIT_SUCCESS;
}
