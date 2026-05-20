// ══════════════════════════════════════════════════════════════════
//  Exercício 02 – Programa de teste da classe Hora
//  CBTLPR1 (Java) – ADS 371
// ══════════════════════════════════════════════════════════════════

public class TesteHora2 {

    // ──────────────────────────────────────────────
    // Utilitário: imprime cabeçalho de seção
    // ──────────────────────────────────────────────
    static void secao(String titulo) {
        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.printf ("║  %-40s║%n", titulo);
        System.out.println("╚══════════════════════════════════════════╝");
    }

    // ──────────────────────────────────────────────
    // Utilitário: exibe todos os dados de um objeto Hora
    // ──────────────────────────────────────────────
    static void exibirHora2(String label, Hora2 h) {
        System.out.println("  " + label);
        System.out.println("    getHor()      → " + h.getHor());
        System.out.println("    getMin()      → " + h.getMin());
        System.out.println("    getSeg()      → " + h.getSeg());
        System.out.println("    getHora1()    → " + h.getHora1()    + "  (formato 24h)");
        System.out.println("    getHora2()    → " + h.getHora2()    + "  (formato 12h AM/PM)");
        System.out.println("    getSegundos() → " + h.getSegundos() + " s");
    }

    // ══════════════════════════════════════════════
    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║      TESTE COMPLETO DA CLASSE Hora       ║");
        System.out.println("╚══════════════════════════════════════════╝");

        // ── TESTE 1: Construtor parametrizado (valores válidos) ──────
        secao("TESTE 1 – Hora2(int h, int m, int s) válido");
        Hora2 h1 = new Hora2(13, 45, 30);
        exibirHora2("Hora2(13, 45, 30)", h1);

        // ── TESTE 2: Construtor parametrizado – casos-limite ─────────
        secao("TESTE 2 – Casos-limite do construtor parametrizado");

        Hora2 hMeiaNoite = new Hora2(0, 0, 0);
        exibirHora2("Hora2(0, 0, 0) – meia-noite", hMeiaNoite);

        Hora2 hMeiodia = new Hora2(12, 0, 0);
        exibirHora2("Hora2(12, 0, 0) – meio-dia", hMeiodia);

        Hora2 hMaxima = new Hora2(23, 59, 59);
        exibirHora2("Hora2(23, 59, 59) – horário máximo", hMaxima);

        // ── TESTE 3: Construtor parametrizado – valor inválido ───────
        secao("TESTE 3 – Construtor parametrizado com valor inválido");
        System.out.println("  Tentativa: Hora2(25, 70, 80) — deve lançar IllegalArgumentException");
        try {
            Hora2 hInvalida = new Hora2(25, 70, 80);
            System.out.println("  ERRO: exceção não foi lançada!");
        } catch (IllegalArgumentException e) {
            System.out.println("  ✔ Exceção capturada corretamente: " + e.getMessage());
        }

        // ── TESTE 4: Setters com parâmetro ───────────────────────────
        secao("TESTE 4 – setHor(int), setMin(int), setSeg(int)");
        Hora2 h4 = new Hora2(0, 0, 0);
        System.out.println("  Antes → " + h4.getHora1());
        h4.setHor(8);
        h4.setMin(30);
        h4.setSeg(15);
        System.out.println("  Após setHor(8), setMin(30), setSeg(15):");
        exibirHora2("h4", h4);

        // ── TESTE 5: getHora1 e getHora2 em vários horários ─────────
        secao("TESTE 5 – getHora1() e getHora2() em vários horários");
        int[][] horarios = {
            {0,  0,  0},   // meia-noite
            {0,  0,  1},   // 1 segundo após meia-noite
            {1,  0,  1},   // 01:00:01 → 3601 s
            {6, 30,  0},   // manhã
            {12, 0,  0},   // meio-dia
            {14, 22, 45},  // tarde
            {23, 59, 59}   // quase meia-noite
        };
        System.out.printf("  %-12s  %-12s  %-18s  %s%n",
                          "Parâmetros", "24h", "12h AM/PM", "Segundos");
        System.out.println("  " + "─".repeat(62));
        for (int[] t : horarios) {
            Hora2 tmp = new Hora2(t[0], t[1], t[2]);
            System.out.printf("  (%2d,%2d,%2d)    %-12s  %-18s  %d%n",
                t[0], t[1], t[2],
                tmp.getHora1(), tmp.getHora2(), tmp.getSegundos());
        }

        // ── TESTE 6: getSegundos – verificação aritmética ────────────
        secao("TESTE 6 – getSegundos() verificação aritmética");
        Hora2 h6a = new Hora2(1, 0, 1);
        Hora2 h6b = new Hora2(0, 1, 0);
        Hora2 h6c = new Hora2(23, 59, 59);
        System.out.println("  01:00:01 → " + h6a.getSegundos() + " s  (esperado: 3601)");
        System.out.println("  00:01:00 → " + h6b.getSegundos() + " s  (esperado: 60)");
        System.out.println("  23:59:59 → " + h6c.getSegundos() + " s  (esperado: 86399)");

        boolean ok1 = h6a.getSegundos() == 3601;
        boolean ok2 = h6b.getSegundos() == 60;
        boolean ok3 = h6c.getSegundos() == 86399;
        System.out.println("  Resultados: "
            + (ok1 ? "✔" : "✗") + " 3601  "
            + (ok2 ? "✔" : "✗") + " 60  "
            + (ok3 ? "✔" : "✗") + " 86399");

        // ── RESUMO ───────────────────────────────────────────────────
        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║  Todos os testes automáticos concluídos. ║");
        System.out.println("║  (Teste interativo omitido nesta versão) ║");
        System.out.println("╚══════════════════════════════════════════╝");

        // NOTA: O construtor Hora2() e os setters interativos (setHor(),
        // setMin(), setSeg()) leem dados do teclado via Scanner.
        // Para testá-los, descomente o bloco abaixo:
        //
        // secao("TESTE INTERATIVO – construtor Hora2()");
        // System.out.println("  Siga as instruções para digitar hora/min/seg:");
        // Hora2 hInterativa = new Hora2();
        // exibirHora2("Hora digitada pelo usuário", hInterativa);
        //
        // secao("TESTE INTERATIVO – setHor() / setMin() / setSeg()");
        // hInterativa.setHor();
        // hInterativa.setMin();
        // hInterativa.setSeg();
        // exibirHora2("Hora após redigitar pelo usuário", hInterativa);
    }
}
