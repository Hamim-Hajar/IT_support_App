import {User} from "./user";
import {Ticket} from "./ticket";
import {Userrole} from "../ennums/userrole";

export class Userstandard  extends User {
  ticketList: Ticket[];

  constructor(
    id: number,
    fullName: string,
    username: string,
    password: string,
    email: string,
    role: Userrole,
    speciality?: string,
    ticketList: Ticket[] = []
  ) {
    super(id, fullName, username, password, email, role, speciality);
    this.ticketList = ticketList;
  }
}
