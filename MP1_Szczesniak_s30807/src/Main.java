void main() {
    List<String> g1Names = List.of("Janek", "Andżej");
    GymMember g1 = new GymMember(g1Names,"Pietruszkowski","Plock","Sloneczna","09-123",76.5,178.5);
    // lub
    GymMember g2 = new GymMember(List.of("Janek", "Andżej"),"Pietruszkowski","Plock","Sloneczna","09-123",76.5,178.5);

    System.out.println(g1.getPhoneNumber());

}
