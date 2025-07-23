
export type ResultType<T> = {
  statusCode: number;
  success: boolean;
  message: string;
  data: T;
}
