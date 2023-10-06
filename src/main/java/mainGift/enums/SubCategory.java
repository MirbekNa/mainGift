package mainGift.enums;

public enum SubCategory {
    LAPTOP(Category.ELECTRONIC),
    SMARTPHONE(Category.ELECTRONIC),

    SHIRTS(Category.CLOTHING),
    DRESSES(Category.CLOTHING),

    FICTION(Category.BOOKS),
    NON_FICTION(Category.BOOKS),

    ACTION_FIGURES(Category.TOYS),
    PUZZLES(Category.TOYS);

    private final Category category;

    SubCategory(Category category) {
        this.category = category;
    }
}
