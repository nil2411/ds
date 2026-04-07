#include <stdio.h>
#include <omp.h>

int main() {
int arr[8] = {1,2,3,4,5,6,7,8};
int n = 8;
int total_sum = 0;

#pragma omp parallel
{
    int id = omp_get_thread_num();
    int total_threads = omp_get_num_threads();
    int local_sum = 0;

    int chunk = n / total_threads;
    int start = id * chunk;
    int end = start + chunk;

    for (int i = start; i < end; i++) {
        local_sum += arr[i];
    }

    printf("Thread %d: Intermediate Sum = %d\n", id, local_sum);

    #pragma omp critical
    total_sum += local_sum;
}

printf("Final Sum = %d\n", total_sum);
return 0;

}
