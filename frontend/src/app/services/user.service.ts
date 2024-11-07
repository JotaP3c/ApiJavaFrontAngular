import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface User {
  id?: number;
  nome: string;
  email: string;
  dataCriacao?: string;
}

@Injectable
({
  providedIn: 'root'
})
export class UserService 
{
  private apiUrl = 'http://localhost:8080/users'; // Preciso setar a url do endpoint da api java  //

  constructor(private http: HttpClient) {}

  // aqui pega todos os usuarios existentes //
  getUsers(): Observable<User[]> 
  {
    return this.http.get<User[]>(this.apiUrl);
  }

  // aqui é para criar um novo usuário //
  addUser(user: User): Observable<User> 
  {
    return this.http.post<User>(this.apiUrl, user);
  }

  // atualizar um usuário existente //
  updateUser(id: number, user: User): Observable<User> 
  {
    return this.http.put<User>(`${this.apiUrl}/${id}`, user);
  }

  // Excluir um usuário //
  deleteUser(id: number): Observable<void> 
  {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
