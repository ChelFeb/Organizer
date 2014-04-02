Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek() - 7);
        calendar.add(Calendar.HOUR, - calendar.getTime().getHours());
        Date startOfWeek = calendar.getTime();
        calendar.add(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek() + 7);
        Date endOfWeek = calendar.getTime();

        Calendar calendar1 = new GregorianCalendar();
        calendar1.add(Calendar.HOUR, - calendar1.getTime().getHours());
        Date startOfDay = calendar1.getTime();
        calendar1.add(Calendar.HOUR, 24 - calendar1.getTime().getHours());
        Date endOfDay = calendar1.getTime();


        List<Event> eventListOfDay = eventService.getEventsForUserByDate(startOfDay, endOfDay, userService.getCurrentUser());
        List<Event> eventListOfWeek = eventService.getEventsForUserByDate(startOfWeek, endOfWeek, userService.getCurrentUser());

        System.err.println(eventListOfDay.size());
        for (int i = 0; i < eventListOfDay.size() ; i++) {
            System.out.println(" + + + + + + + + + + + ");
            System.out.println(eventListOfDay.get(i).getSubject());
            System.out.println(eventListOfDay.get(i).getDescription());
            System.out.println(" + + + + + + + + + + + ");
        }

        Map<String, List<Event>> map = new HashMap<String, List<Event>>();



