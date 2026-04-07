#include <stdio.h>
#include <mpi.h>

int main(int argc, char *argv[]) {
int rank, size;
int arr[8] = {1,2,3,4,5,6,7,8};
int local_sum = 0, total_sum = 0;

MPI_Init(&argc, &argv);
MPI_Comm_rank(MPI_COMM_WORLD, &rank);
MPI_Comm_size(MPI_COMM_WORLD, &size);

int chunk = 8 / size;
int start = rank * chunk;
int end = start + chunk;

for (int i = start; i < end; i++) {
    local_sum += arr[i];
}

printf("Processor %d: Intermediate Sum = %d\n", rank, local_sum);

MPI_Reduce(&local_sum, &total_sum, 1, MPI_INT, MPI_SUM, 0, MPI_COMM_WORLD);

if (rank == 0) {
    printf("Final Sum = %d\n", total_sum);
}

MPI_Finalize();
return 0;

}
