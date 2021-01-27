/*
	Corrected File Corresponding to my suggested comments in the main file.
*/

import { isReminderSelector } from '../../src/selectors/remSelector';
import { useSubscription } from '../../src/utils/Helper';

import { WatcherResult } from 'conduit-view';
import { useEffect, useMemo, useRef, useState, useCallback } from 'react';

import { Result,NoteListQueryResult,GetNotesTabNoteListQuery,NoteListPlain} from 'ion-actions/note/getNotes';

import { selectedNoteSelector } from '../../src/selectors/notesSelector';


import { OnRowsRenderedNode } from '@node_modules/react-virtualized-sticky-tree';

import { useSelector } from 'react-redux';

export const NOTE_LIST_SIZE = 500;

const ANOTHER_CONST = 0.7;


const INITIAL_START_INDEX = 0;
const INITIAL_START_KEY = null;
const DEBUG_PAGINATION = false;

export const USE_NOTE_LIST_SUBSCRIBED_TO_PARENT_NOTE_LIST_IN_THE_HOME_VIEW_OF_THE_WEBAPP  = (
  filters,sort,disablePagination,skip: boolean = false) => {
  const X = UseSelector(IsReminderSelector);
  const [CURR_PAGE, SET_CURR_PAGE_KEY] = useState<null | string>(null);
  const [START_INDEX, SET_START_INDEX] = useState(INITIAL_START_INDEX);
  const TOTAL_NOTES = useRef<number>(0);
  const CURRENT_PAGE = useSubscription(
    GetNotesTabNoteListQuery,
    {
      noteFilters: filters,
    }
  );
  
  const IS_CURRENT_PAGE_EMPTY  = CURRENT_PAGE.data?.list.length == 0;
  
  const NUM_PRIOR_ITEMS  = CURRENT_PAGE?.data?.NUM_PRIOR_ITEMS  ?? 0;
  
  const PREV_PAGE_SIZE  = NUM_PRIOR_ITEMS < NOTE_LIST_SIZE  ? NUM_PRIOR_ITEMS : NOTE_LIST_SIZE ;
	
  const SHOULD_PREV_PAGE_LOAD  = (CURRENT_PAGE.data != null )&& (CURRENT_PAGE.data?.NUM_PRIOR_ITEMS > 0) && (!disablePagination);

  
  const RANDOM_FUNCTION = UseMemo(() => {
    let innerlist = CURRENT_PAGE.data.concat(
        addDebugInfo(CURRENT_PAGE?.data ?? [], {
          pageName: 'current',
          cached: CURRENT_PAGE === null,
        })
      )
    return innerlist;
  }, [
    disablePagination,
    START_INDEX,
    CURRENT_PAGE,
    IS_CURRENT_PAGE_EMPTY,
  ]);
  
  const RESULT = useMemo(
    () => ({
      ...CURRENT_PAGE.data,
    }),
    [
      CURRENT_PAGE
    ]
  );
  return RESULT;
};

function createPlaceholders(count: number, selectedID?: string | null): Result {

  const PLACE_HOLDERS: Array<Record<string, unknown>> = new Array(count);
  PLACE_HOLDERS
    .fill(
      {
        id: selectedID,
        label: null,
        updated: null,
        debugInfo: { placeholder: true },
      },
      0,
      1
    )
    .fill(
      {
        id: null,
        label: null,
        updated: null,
        debugInfo: { placeholder: true },
      },
      1,
      count
    );
	
  return (PLACE_HOLDERS as unknown) as Result;
}

function addDebugInfo(
  list: RESULT,
  debugInfo: {
    pageName: PageName;
    cached: boolean;
  }
): RESULT {
  if (DEBUG_PAGINATION) {
    return list.map(item => ({ ...item, debugInfo }));
  }
  return list;
}
