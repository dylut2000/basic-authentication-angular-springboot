export type UserRoleType = 'ADMIN' | 'USER';

export type LoginRequestType = {
  username: string;
  password: string;
};

export type RegisterRequestType = LoginRequestType & {
  role: UserRoleType;
};

export type UserType = {
  id: string;
  username: string;
  role: UserRoleType;
  createdAt: string;
}

export type UserTokenType = {
  token: string;
  user: UserType;
};


export type AuthStateType = {
  user: UserType | null;
  token: string | null;
  loading: boolean;
  isLoggedIn: boolean;
  error: string | null;
}
