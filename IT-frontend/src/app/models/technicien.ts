import {User} from "./user";
import {Ticket} from "./ticket";
import {Userrole} from "../ennums/userrole";

export class Technicien extends User {
  override tickets: Ticket[];

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
    super(id, fullName, username, password, email, role, speciality);
    this.tickets = tickets;
  }
}
