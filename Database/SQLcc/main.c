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
int main() {

    printf("SQLcc is started!\n");
    InputBuffer *inputBuffer = (InputBuffer *) malloc(sizeof(InputBuffer));

    while (1 == 1) {
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
            printf("SQLcc Command not found !\n");
        }
    }

    return EXIT_SUCCESS;
}
