import {Userrole} from "../ennums/userrole";
import {Ticket} from "./ticket";

export class User {
  id: number;
  fullName: string;
  username: string;
  password: string; // Note: Password should be handled securely and not exposed
  email: string;
  role: Userrole;
  speciality?: string;
  tickets: Ticket[];

  constructor(
    id: number,
    fullName: string,
    username: string,
    password: string,
    email: string,
    role: Userrole,
    speciality?: string,
    tickets: Ticket[] = []
  ) {
    this.id = id;
    this.fullName = fullName;
    this.username = username;
    this.password = password;
    this.email = email;
    this.role = role;
    this.speciality = speciality;
    this.tickets = tickets;
  }
}
