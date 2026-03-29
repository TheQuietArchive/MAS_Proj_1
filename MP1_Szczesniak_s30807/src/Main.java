void main() {
    String extentFile = "extent.dat";
    File file = new File(extentFile);


    try {
        if (file.exists()) {
            var in = new ObjectInputStream(new FileInputStream(extentFile));
            GymMember.readExtent(in);
            Address.readExtent(in);

            in.close();
            System.out.println("Wczytano extent z pliku.\n");
        } else {
            System.out.println("Brak pliku – przechodzę dalej.\n");
        }
    } catch (IOException | ClassNotFoundException e) { e.printStackTrace();}

    GymMember member = new GymMember(
            List.of("Janek", "Andżej"),
            "Marchewkowicz",
            "Plock",
            "Sloneczna",
            "09-123",
            76.5,
            178.5,
            "123456789"
    );

    //Example use
    System.out.println("BMI: " + member.getBMI());
    System.out.println("Surname: " + member.getSurname());

    member.setWeight(80);
    System.out.println("New BMI: " + member.getBMI());

    System.out.println();
    System.out.println(member);
    System.out.println();

    //Show extent
    System.out.println(GymMember.getExtent());
    System.out.println(Address.getExtent());

    if (file.exists()) {
        file.delete();
    }

    try {
        var out = new ObjectOutputStream(new FileOutputStream(extentFile));
        GymMember.writeExtent(out);
        Address.writeExtent(out);

        out.close();
        System.out.println("Zapisano extent do pliku.\n");

    } catch (IOException e) { e.printStackTrace();}
}
